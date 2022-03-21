package org.practica2mps.DoubleLinkedListQueue;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListQueueTest {


    @Test
    public void checkAppendNodeNonEmptyList(){
        DequeNode node1 = new DequeNode(new Object(),null,null);
        DequeNode node2 = new DequeNode(new Object(),null,node1);
        node1.setNext(node2);
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(node1,node2);
        DequeNode node3 = new DequeNode(new Object(),null,null);
        int sizeBefore = list.size;
        list.append(node3);
        int sizeAfter = list.size;
        sizeAfter--; // debería de ser igual al anterior


        assertEquals(sizeBefore,sizeAfter);

        assertEquals(list.last.getPrevious().getNext(),list.last);
    }

    @Test
    public void checkAppendLeftNodeNonEmptyList(){
        DequeNode node1 = new DequeNode(new Object(),null,null);
        DequeNode node2 = new DequeNode(new Object(),null,node1);
        node1.setNext(node2);
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(node1,node2);
        DequeNode node3 = new DequeNode(new Object(),null,null);
        int sizeBefore = list.size;
        list.appendLeft(node3);
        int sizeAfter = list.size;
        sizeAfter--; // debería de ser igual al anterior


        assertEquals(sizeBefore,sizeAfter);
        assertEquals(list.first.getNext().getPrevious(),list.first);
    }

    @Test
    public void checkDeleteFirstNodeListSizeGreaterThan2(){
        DequeNode node1 = new DequeNode(new Object(),null,null);
        DequeNode node2 = new DequeNode(new Object(),null,node1);
        DequeNode node3 = new DequeNode(new Object(),null,null);
        node1.setNext(node2);
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(node1,node2);
        list.append(node3);
        list.deleteFirst();

        int sizeBefore = list.size;
        list.deleteLast();
        int sizeAfter = list.size;
        sizeAfter++; // debería de ser igual al anterior

        assertEquals(node2,list.first);
        assertNull(list.first.getPrevious());
        assertEquals(sizeBefore,sizeAfter);
    }

    @Test
    public void checkDeleteFirstNodeListSizeEquals2(){
        DequeNode node1 = new DequeNode(new Object(),null,null);
        DequeNode node2 = new DequeNode(new Object(),null,node1);
        node1.setNext(node2);

        DoubleLinkedListQueue list = new DoubleLinkedListQueue(node1,node2);

        list.deleteFirst();

        assertEquals(node2,list.first);
        assertNull(list.first.getNext());
        assertNull(list.first.getPrevious());
        assertEquals(list.size,1);
    }

    @Test
    public void checkDeleteLastNodeListSizeEquals2(){
        DequeNode node1 = new DequeNode(new Object(),null,null);
        DequeNode node2 = new DequeNode(new Object(),null,node1);
        node1.setNext(node2);
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(node1,node2);
        list.deleteLast();


        assertEquals(list.last,list.first);
        assertNull(list.first.getNext());
        assertNull(list.first.getPrevious());
        assertEquals(list.size,1);
    }

    @Test
    public void checkDeleteLastNodeListSizeGreaterThan2(){
        DequeNode node1 = new DequeNode(new Object(),null,null);
        DequeNode node2 = new DequeNode(new Object(),null,node1);
        DequeNode node3 = new DequeNode(new Object(),null,node1);
        node1.setNext(node2);
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(node1,node2);
        list.append(node3);
        int sizeBefore = list.size;
        list.deleteLast();
        int sizeAfter = list.size;
        sizeAfter++; // debería de ser igual al anterior


        assertEquals(node2,list.last);
        assertNull(list.last.getNext());
        assertEquals(sizeBefore,sizeAfter);
    }

    @Test
    public void checkPeekFirst(){
        DequeNode node1 = new DequeNode(new Object(),null,null);
        DequeNode node2 = new DequeNode(new Object(),null,node1);
        node1.setNext(node2);
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(node1,node2);

        int sizeBefore = list.size;
        DequeNode peeked = list.peekFirst();
        int sizeAfter = list.size;

        assertEquals(peeked,list.first);
        assertEquals(sizeBefore,sizeAfter);
    }

    @Test
    public void checkPeekLast(){
        DequeNode node1 = new DequeNode(new Object(),null,null);
        DequeNode node2 = new DequeNode(new Object(),null,node1);
        node1.setNext(node2);
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(node1,node2);

        int sizeBefore = list.size;
        DequeNode peeked = list.peekLast();
        int sizeAfter = list.size;

        assertEquals(peeked,list.last);
        assertEquals(sizeBefore,sizeAfter);
    }

    @Test
    public void checkGetAtPosition1ShouldReturnNode2(){
        DequeNode node1 = new DequeNode(new Object(),null,null);
        DequeNode node2 = new DequeNode(new Object(),null,node1);
        node1.setNext(node2);
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(node1,node2);

        int sizeBefore = list.size;
        DequeNode gettedAt1 = list.getAt(1);
        int sizeAfter = list.size;

        assertEquals(gettedAt1,list.last);
        assertEquals(sizeBefore,sizeAfter);
    }

    @Test
    public void checkGetAtPositionShouldRaiseAnExceptionIfNumberUnder0(){
        DequeNode node1 = new DequeNode(new Object(),null,null);
        DequeNode node2 = new DequeNode(new Object(),null,node1);
        node1.setNext(node2);
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(node1,node2);

        assertThrows(RuntimeException.class,() -> list.getAt(-1) );

    }

    @Test
    public void checkGetAtPositionShouldRaiseAnExceptionIfNumberGreaterThanSize(){
        DequeNode node1 = new DequeNode(new Object(),null,null);
        DequeNode node2 = new DequeNode(new Object(),null,node1);
        node1.setNext(node2);
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(node1,node2);

        int position = list.size + 1;

        assertThrows(RuntimeException.class,() -> list.getAt(position) );

    }

    @Test
    public void checkDeleteTheFirstNodeWhereListSizeEquals2(){
        DequeNode node1 = new DequeNode(new Object(),null,null);
        DequeNode node2 = new DequeNode(new Object(),null,node1);
        node1.setNext(node2);
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(node1,node2);

        int sizeBefore = list.size;
        list.delete(node1);
        int sizeAfter = list.size;
        sizeAfter++; // debería de ser igual al anterior


        assertEquals(node2,list.first);
        assertNull(list.first.getNext());
        assertNull(list.first.getPrevious());
        assertEquals(sizeBefore,sizeAfter);
    }

    @Test
    public void checkDeleteTheLastNodeWhereListSizeEquals2(){
        DequeNode node1 = new DequeNode(new Object(),null,null);
        DequeNode node2 = new DequeNode(new Object(),null,node1);
        node1.setNext(node2);
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(node1,node2);

        int sizeBefore = list.size;
        list.delete(node2);
        int sizeAfter = list.size;
        sizeAfter++; // debería de ser igual al anterior


        assertEquals(node1,list.first);
        assertNull(list.first.getNext());
        assertNull(list.first.getPrevious());
        assertEquals(sizeBefore,sizeAfter);
    }

    @Test
    public void checkDeleteAMiddleNodeWhereListSizeGreaterThan2(){
        DequeNode node1 = new DequeNode(new Object(),null,null);
        DequeNode node2 = new DequeNode(new Object(),null,node1);
        DequeNode node3 = new DequeNode(new Object(),null,null);
        node1.setNext(node2);
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(node1,node2);
        list.append(node3);
        DoubleLinkedListQueue list2 = new DoubleLinkedListQueue(node1,node3);
        node1.setNext(node3);
        node3.setPrevious(node1);

        int sizeBefore = list.size;
        list.delete(node2);
        int sizeAfter = list.size;
        sizeAfter++; // debería de ser igual al anterior


        for(int i = 0; i < list.size;i++)
            assertEquals(list.getAt(i),list2.getAt(i));

        assertEquals(sizeBefore,sizeAfter);
    }









}
