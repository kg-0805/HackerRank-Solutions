// Any global declataions can be done here
import java.util.*;
import java.io.*;

class ClientProcessor extends Thread {

    private static int[] parentLookup;
    private static HashMap<Integer, HashMap<Integer, Double>> edgeLookup;
    
    Socket clientSocket;
    InputStream clientInputStream;
    OutputStream clientOutputStream;
    
    ClientProcessor(Socket socket) throws IOException{
        clientSocket = socket;
        clientInputStream = clientSocket.getInputStream();
        clientOutputStream = clientSocket.getOutputStream();
    }
    
    /*
    This function is called only once before any client connection is accepted by the server.
    Read any global datasets or configurations here
    */
    public static void init_server() throws IOException {
        System.out.println("Initializing server");
        buildLookups("training.txt");
    }
    
    private static void buildLookups(String fileName) throws IOException {
        String currentLine, lineTokens[];
        int numBanks, i, parent, child;
        double threshold;
        HashMap<Integer, Double> edgeMap;
        
        try(
            FileInputStream fileInputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
            edgeLookup = new HashMap<Integer, HashMap<Integer, Double>>();
            
            numBanks = Integer.parseInt(bufferedReader.readLine());
            parentLookup = new int[numBanks + 1];
            
            for(i = 1; i < numBanks; i++) {
                currentLine = bufferedReader.readLine();
                lineTokens = currentLine.split(",");
                
                parent = Integer.parseInt(lineTokens[0]);
                child = Integer.parseInt(lineTokens[1]);
                threshold = Double.parseDouble(lineTokens[2])/100d;
                
                parentLookup[child] = parent;
                if((edgeMap = edgeLookup.get(child)) == null) {
                    edgeMap = new HashMap<Integer, Double>();
                    edgeLookup.put(child, edgeMap);
                }
                
                edgeMap.put(parent, threshold);
            }
        }
    }
    
    private static int findCommonAncestor(int a, int b) {
        List<Integer> aAncestors;
        int current, commonAncestor;
        
        aAncestors = new LinkedList<Integer>();
        
        commonAncestor = 0;
        
        current = a;
        while(current != 0) {
            aAncestors.add(current);
            current = parentLookup[current];
        }
        
        current = b;
        while(current != 0) {
            if(aAncestors.contains(current)) {
                commonAncestor = current;
                break;
            }
            current = parentLookup[current];
        }
        
        return commonAncestor;
    }
    
    private static double calculateProbability(int a, int ancestor) {
        int child, parent;
        double probability;
        
        probability = 1d;
        
        child = a;
        while(child != ancestor) {
            parent = parentLookup[child];
            probability *= edgeLookup.get(child).get(parent);
            child = parent;
        }
        
        return probability;
    }
    
    private static double calculateProbability(int a, int b, int ancestor) {
        return calculateProbability(a, ancestor) * calculateProbability(b, ancestor);
    }
    
    private static String processMessage(String message) {
        String messageTokens[];
        int a, b;
        double q;
        
        messageTokens = message.split(",");
        a = Integer.parseInt(messageTokens[0]);
        b = Integer.parseInt(messageTokens[1]);
        q = Math.pow(10d, Double.parseDouble(messageTokens[2]));
        
        return (calculateProbability(a, b, findCommonAncestor(a, b)) > q) ? "YES" : "NO";
    }

    /*
    Write your code here
    This function is called everytime a new connection is accepted by the server
    */
    public void run() {
        do {
            String message = null;
            
            /* read message */
            try {
                message = read_string_from_socket();
            } catch (IOException ex) {
                System.out.println("Exception: " + ex);
            }

            /* End of operation on this client */
            if (message.equals("END"))
                break;

            System.out.println("Received = " + message);

            /* write message */
            try {
                message = processMessage(message);
                write_string_to_socket(message);
            } catch (IOException ex) {
                System.out.println("Exception: " + ex);
            }
        } while(true);
        
        // Send end of communication. Very important!
        try {
            write_string_to_socket("END");
        } catch (IOException ex) {
            System.out.println("Exception: " + ex);
        }

        try {
            close_socket();
        } catch (IOException ex) {
                System.out.println("Exception: " + ex);
        }

        return;
    }

    /*
    This function encapsulates the communication protocol.
    Do not edit this function
    */
    public String read_string_from_socket() throws IOException {
        // Read payload
        byte[] len_network_order = new byte[4];
        clientInputStream.read(len_network_order);
        
        // Get message length from payload
        ByteBuffer bb = ByteBuffer.wrap(len_network_order);
        int message_length = bb.getInt();

        // Read message length bytes
        byte[] message_bytes = new byte[message_length];
        clientInputStream.read(message_bytes);
        
        // Convert bytes to string and return
        String message = new String(message_bytes, "UTF-8");
        return message;
    }

    /*
    This function encapsulates the communication protocol.
    Do not edit this function
    */    
    public void write_string_to_socket(String message) throws IOException {
        // Read length of message and write message header
        int messageLength = message.length();
        ByteBuffer bb = ByteBuffer.allocate(4);
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.putInt(messageLength);
        bb.flip();
        clientOutputStream.write(bb.array());
        
        // Now write the message itself
        byte[] message_bytes = message.getBytes();
        bb = ByteBuffer.allocate(messageLength);
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.put(message_bytes);
        bb.flip();
        clientOutputStream.write(bb.array());
    }
    
    /*
    This function encapsulates the communication protocol.
    Do not edit this function
    */
    public void close_socket() throws IOException {
        clientInputStream.close();
        clientOutputStream.close();
        clientSocket.close();
    }
}