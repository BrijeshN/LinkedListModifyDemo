/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistmodifydemo;

/**
 *
 * @author Brijesh
 */
public class LinkedListModifyDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        StringLinkedListWithIterator list = new StringLinkedListWithIterator();

        list.addANodeToStart("One");
        list.addANodeToStart("Two");
        list.addANodeToStart("Three");
        System.out.println("List has " + list.length() + " entries.");

        list.showList();

        if (list.onList("Three")) {
            System.out.println("Three is on list.");
        } else {
            System.out.println("Three is NOT on list.");
        }

        System.out.println("End of list.");

    }

}
