# Standard ruby library for XML parsing
require 'rexml/document'
include REXML

# Enter your code here. Read input from STDIN. Print output to STDOUT
xmlText = "" 

# Read the input XML Fragment
while line = gets()
   xmlText += line
end

doc = Document.new xmlText
# XPath Selector for listing the format of the movies with popularity<8, in the same order as which they occur in the given XML.
# Fill in the blanks to complete the required XPath selector query
doc.elements.each("collection/movie/") do |movie|
    movie.elements.each("popularity") do |popularity|
        if (popularity.text.to_i < 8) then
            movie.elements.each("format") do |format|
                puts format.text
            end
        end
    end
end
