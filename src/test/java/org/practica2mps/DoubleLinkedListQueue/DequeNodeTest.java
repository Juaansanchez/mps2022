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
    
    @Test
    public void shouldToStringReturnANonNullString(){
        DequeNode node = new DequeNode(new Object(),null,null);

        assertNotNull(node.toString());

    }

    @Test
    public void shouldGetItemReturnAnItemIfSetThatItemPreviously(){
        DequeNode node = new DequeNode(null,null,null);
        Object itemExpected = new Object();

        node.setItem(itemExpected);

        Object itemObtained = node.getItem();

        assertEquals(itemExpected,itemObtained);

    }

}
