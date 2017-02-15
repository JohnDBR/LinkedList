/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author John
 */
public class Node {

    private int num;
    private Node link;

    public Node(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Node getLink() {
        try {
            return link;
        } catch (Exception ex) {
            return null;
        }
    }

    public void setLink(Node link) {
        this.link = link;
    }
}
