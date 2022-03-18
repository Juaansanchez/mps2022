package org.practica2mps.DoubleLinkedListQueue;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DequeNodeTest {
    @Test
    public void shouldReturnPreviousIsNullIfFirst(){
        DequeNode node = new DequeNode(new Object(),new Object(),null);
        assertNull(node.getPrevious());
    }


    @Test
    public void shouldReturnNextIsNullIfLast(){
        DequeNode node2 = new DequeNode(new Object(),null,new Object());
        assertNull(node2.getNext());
    }

    @Test
    public void shouldReturnTrueIfIsNotATerminalNode(){
        DequeNode node = new DequeNode(new Object(),new Object(),new Object());
        assertTrue(node.isNotATerminalNode());
    }

}
