package org.practica2mps.DoubleLinkedListQueue;

import java.util.Comparator;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue {

    public DequeNode<T> first, last;
    public int size;

    public DoubleLinkedListQueue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public DoubleLinkedListQueue(DequeNode first, DequeNode last) {
        this.first = first;
        this.last = last;
        this.size = 1;
    }


    @Override
    public void append(DequeNode node) {
        if (this.first == null) {
            this.first = node;
            this.size = 1;
        } else {
            this.last.setNext(node);
            this.size++;
        }
        this.last = node;
    }

    @Override
    public void appendLeft(DequeNode node) {
        if (this.first == null) {
            this.last = node;
            this.size = 1;
        } else {
            this.first.setPrevious(node);
            this.size++;
        }
        this.first = node;

    }

    @Override
    public void deleteFirst() {
        if (this.size == 0) {
            System.out.println("Empty queue");
        } else {
            if (this.first == this.last) {
                this.first = null;
                this.last = null;
            } else {
                this.first = this.first.getNext();
                this.first.setPrevious(null);
            }
            this.size--;
        }
    }

    @Override
    public void deleteLast() {
        if (this.size == 0) {
            System.out.println("Empty queue");
        } else {
            if (this.first == this.last) {
                this.first = null;
                this.last = null;
            } else {
                this.last = this.last.getPrevious();
                this.last.setNext(null);
            }
            this.size--;
        }
    }

    @Override
    public DequeNode peekFirst() {
        DequeNode node;
        if (this.size == 0) {
            System.out.println("Empty queue");
            node = null;
        } else {
            node = this.first;
        }
        return node;
    }

    @Override
    public DequeNode peekLast() {
        DequeNode node;
        if (this.size == 0) {
            System.out.println("Empty queue");
            node = null;
        } else {
            node = this.last;
        }
        return node;

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public DequeNode getAt(int position) {
        DequeNode node;

        if (position < 0 || position > this.size) {
            throw new RuntimeException("Position " + position + "invalid");
        } else {

            if (this.size == 0) {
                System.out.println("Empty queue");
                node = null;
            } else {
                int i = 0;
                node = this.first;
                while ((node != null) && (i != position)) {
                    node = node.getNext();
                    i++;
                }
            }
        }
        return node;
    }

    @Override
    public DequeNode find(Object item) {
        DequeNode node;

        if (this.size == 0) {
            System.out.println("Empty queue");
            node = null;
        } else {
            node = this.first;
            while ((node != null) && !(node.getItem().equals(item))) {
                node = node.getNext();
            }
        }
        return node;
    }

    @Override
    public void delete(DequeNode node) {
        if (this.size == 0) { //La cola esta vacia
            System.out.println("Empty queue");
        } else { // La cola no esta vacia
            DequeNode aux = this.first;

            while (aux != node) { // Busco si el nodo se encuentra en la cola
                aux = aux.getNext();
            }

            if(aux != null){ // El nodo está en la cola
                if(aux == this.first){ // Elimino el primer nodo
                    this.deleteFirst();
                }else if(aux == this.last){ // Elimino el ultimo nodo
                    this.deleteLast();
                }else{ // Elimino un nodo intermedio
                    aux.getNext().setPrevious(aux.getPrevious());
                    aux.getPrevious().setNext(aux.getNext());
                }
            }else{ // El nodo no está en la cola
                System.out.println("The node is not in the queue.");
            }
        }
    }

    @Override
    public void sort(Comparator comparator) {

    }
}






