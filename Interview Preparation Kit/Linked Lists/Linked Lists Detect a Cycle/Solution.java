/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    
    
    if(head==null)
        return false;
    else{
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null && fast!=slow){
            slow=slow.next;
            fast=fast.next.next;
        }
        if( fast!=null && fast==slow)
            return true;
        return false;
    }    

}