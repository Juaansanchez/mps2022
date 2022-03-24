package org.practica2mps.DoubleLinkedListQueue;

import org.junit.jupiter.api.*;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListQueueTest {

    @Test
    public void checkAppendNodeEmptyList(){
        DequeNode node1 = new DequeNode(new Object(),null,null);

        DoubleLinkedListQueue list = new DoubleLinkedListQueue();

        int sizeBefore = list.size;
        list.append(node1);
        int sizeAfter = list.size;
        sizeAfter--; // debería de ser igual al anterior

        assertEquals(sizeBefore,sizeAfter);
        assertEquals(node1,list.first);
    }


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
    public void checkAppendLeftNodeEmptyList(){
        DequeNode node1 = new DequeNode(new Object(),null,null);

        DoubleLinkedListQueue list = new DoubleLinkedListQueue();

        int sizeBefore = list.size;
        list.appendLeft(node1);
        int sizeAfter = list.size;
        sizeAfter--; // debería de ser igual al anterior

        assertEquals(sizeBefore,sizeAfter);
        assertEquals(node1,list.first);
    }

    @Test
    public void checkDeleteFirstOnAEmptyListRaiseAnException(){
        DoubleLinkedListQueue list = new DoubleLinkedListQueue();
        assertThrows(RuntimeException.class, () -> list.deleteFirst());
    }

    @Test
    public void checkDeleteLastOnAEmptyListRaiseAnException(){
        DoubleLinkedListQueue list = new DoubleLinkedListQueue();
        assertThrows(RuntimeException.class, () -> list.deleteLast());
    }

    @Test
    public void checkDeleteFirstNodeListSizeEqualsOne(){
        DequeNode node1 = new DequeNode(new Object(),null,null);
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(node1,null);
        list.deleteFirst();

        assertNull(list.first);
        assertNull(list.last);

    }


    @Test
    public void checkDeleteLastNodeListSizeEqualsOne(){
        DequeNode node1 = new DequeNode(new Object(),null,null);
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(node1,null);
        list.deleteLast();

        assertNull(list.first);
        assertNull(list.last);

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
    public void checkPeekFirstOnAEmptyListRaiseAnException(){
        DoubleLinkedListQueue list = new DoubleLinkedListQueue();
        assertThrows(RuntimeException.class, () -> list.peekFirst());
    }

    @Test
    public void checkPeekLastOnAEmptyListRaiseAnException(){
        DoubleLinkedListQueue list = new DoubleLinkedListQueue();
        assertThrows(RuntimeException.class, () -> list.peekLast());
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
    public void checkGetAtPositionOnAEmptyListShouldRaiseAnException(){
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(null,null);
        assertThrows(RuntimeException.class,() -> list.getAt(0) );
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
    public void checkDeleteOnAEmptyListShouldRaiseAnException(){
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(null,null);
        assertThrows(RuntimeException.class,() -> list.delete(new DequeNode(new Object(),null,null)) );
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

        int sizeBefore = list.size;
        list.delete(node2);
        int sizeAfter = list.size;
        sizeAfter++; // debería de ser igual al anterior

        assertEquals(list.first,node1);
        assertEquals(list.last,node3);
        assertEquals(list.first.getNext(),node3);
        assertEquals(list.last.getPrevious(),node1);

        assertEquals(sizeBefore,sizeAfter);
    }

    @Test
    public void checkDeleteANodeThatIsNotInTheListShouldRaiseAnException(){
        DequeNode node1 = new DequeNode(new Object(),null,null);
        DequeNode node2 = new DequeNode(new Object(),null,node1);
        DequeNode node3 = new DequeNode(new Object(),null,null);
        node1.setNext(node2);
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(node1,node2);

        assertThrows(RuntimeException.class,() -> list.delete(node3));
    }

    @Test
    public void checkFindOnAEmptyListRaiseAnException(){
        DoubleLinkedListQueue list = new DoubleLinkedListQueue();
        assertThrows(RuntimeException.class, () -> list.find(new Object()));
    }

    @Test
    public void checkFindAnObjectThatIsNotInTheListRaiseAnException(){
        DequeNode node1 = new DequeNode(new Object(),null,null);
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(node1,null);

        assertThrows(RuntimeException.class, () -> list.find(new Object()));
    }

    @Test
    public void checkFindAnObjectOnANonEmptyList(){
        Object obj = new Object();
        DequeNode node1 = new DequeNode(obj,null,null);
        DoubleLinkedListQueue list = new DoubleLinkedListQueue(node1,null);

        assertEquals(obj,list.find(obj).getItem());
    }


}
