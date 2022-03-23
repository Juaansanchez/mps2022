package org.practica2mps.DoubleLinkedListQueue;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DequeNodeTest {
    @Test
    public void shouldReturnPreviousIsNullIfIsFirst(){
        DequeNode node = new DequeNode(new Object(),null,null);
        assertNull(node.getPrevious());
    }


    @Test
    public void shouldReturnNextIsNullIfIsLast(){
        DequeNode node2 = new DequeNode(new Object(),null,null);
        assertNull(node2.getNext());
    }

    @Test
    public void shouldReturnTrueIfIsNotATerminalNode(){
        DequeNode node = new DequeNode(new Object(),null,null);
        DequeNode first = new DequeNode(new Object(),node,null);
        DequeNode last = new DequeNode(new Object(),null,node);

        node.setPrevious(first);
        node.setNext(last);

        assertTrue(node.isNotATerminalNode());
    }

}
