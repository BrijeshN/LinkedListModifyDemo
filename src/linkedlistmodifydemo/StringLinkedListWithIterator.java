/**
 * Linked list with an iterator. One node is the "current node."
 * Initially, the current node is the first node. It can be changed
 * to the next node until the iteration has moved beyond the end
 * of the list.
 */

package linkedlistmodifydemo;

public class StringLinkedListWithIterator {
    
    // Three private instance variables
    private ListNode head;
    private ListNode current;
    private ListNode previous;
    
    public StringLinkedListWithIterator(){
        this.head = null;
        this.current = null;
        this.previous = null;
    }
    
    public void addANodeToStart(String addData){
        this.head = new ListNode(addData, head);
        if((this.current == head.link) && (this.current != null)){
            // if current is at old start node
            this.previous = this.head;
        }
    }
    
    /**
     * Sets iterator to beginning of list.
     */
    public void resetIteration(){
        this.current = head;
        this.previous = null;
    }
    
    /**
     * Returns true if iteration is not finished.
     */
    public boolean moreToIterate(){
        return this.current != null;
    }
    
    /**
     * Advances iterator to next node.
     */
    public void goToNext(){
        if(this.current != null){
            this.previous = current;
            this.current = current.link;
        } else if (this.head != null) {
            System.out.println("Iterated too many times or uninitialized iteration.");
            System.exit(0);
        } else {
            System.out.println("Iterating with an empty list.");
            System.exit(0);
        }
            
    }
    
    /**
     * Returns the data at the current node.
     */
    public String getDataAtCurrent(){
        String result = null;
        if(this.current != null){
            result = current.data;
        } else {
            System.out.println("Getting data when current is not at any node.");
            System.exit(0);
        }
        
        return result;
    }
    
    /**
     * Replaces the data at the current node.
     */
    public void setDataAtCurrent(String newData){
        if(this.current != null){
            current.data = newData;
        } else {
            System.out.println("Setting data when current is not at any node.");
            System.exit(0);
        }
    }
    
    /**
     * Inserts a new node containing newData after the current node.
     * The current node is the same after invocation as it is before.
     * Precondition: List is not empty; current node is not
     * beyond the entire list.
     */
    public void insertNodeAfterCurrent(String newData){
        ListNode newNode = new ListNode();
        newNode.data = newData;
        if(this.current != null){
            newNode.link = current.link;
            current.link = newNode;
        } else if (this.head != null){
            System.out.println("Inserting when iterator is past all nodes or is not initialized.");
            System.exit(0);
        } else {
            System.out.println("Using insertNodeAfterCurrent with empty list.");
            System.exit(0);
        }
    }
    
    /**
     * Deletes the current node. After the invocation,
     * the current node is either the node after the
     * deleted node or null if there is no next node.
     */
    public void deleteCurrentNode(){
        if((this.current != null) && (this.previous != null)){
            previous.link = current.link;
            this.current = current.link;
        } else if ((this.current != null) && (previous == null)){
            // At head node
            this.head = current.link;
            this.current = head;
        } else {
            System.out.println("Deleting with uninitialized current or an empty list.");
            System.exit(0);
        }
    }
    
    /**
     * Display the data on the list.
     */
    public void showList(){
        ListNode position = head;
        while(position != null){
            System.out.println(position.data);
            position = position.link;
        }
    }
    
    /**
     * Returns the number of nodes on the list.
     */
    public int length(){
        int count = 0;
        ListNode position = head;
        while(position != null){
            count++;
            position = position.link;
        }
        return count;
    }
    
    /**
     * Sees whether target is on the list.
     */
    public boolean onList(String target){
        return find(target) != null;
    }
    
    /**
     * Returns a reference to the first node containing the 
     * target data. If target is not on the list, returns null.
     */
    private ListNode find(String target){
        boolean found = false;
        ListNode position = head;
        while((position != null) && !found){
            String dataAtPosition = position.data;
            if(dataAtPosition.equals(target)){
                found = true;
            } else {
                position = position.link;
            }
        }
        
        return position;
        
    }
    
    /**
     * Returns an array of the elements on the list.
     */
    public String[] toArray(){
        String[] anArray = new String[length()];
        ListNode position = head;
        int i = 0;
        while (position != null){
            anArray[i] = position.data;
            i++;
            position = position.link;
        }
        return anArray;
    }
    
    private class ListNode {
        private String data;
        private ListNode link;
        
        public ListNode(){
            this.data = null;
            this.link = null;
        }
        
        public ListNode(String newData, ListNode linkValue){
            this.data = newData;
            this.link = linkValue;
        }
    }
 
}
