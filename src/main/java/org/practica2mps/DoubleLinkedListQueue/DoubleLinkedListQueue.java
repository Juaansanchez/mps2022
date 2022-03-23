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
        try{
            if(first == null && last == null) {
                this.size = 0;
                this.first = null;
                this.last = null;
            }
            else if(last == null) {
                this.size = 1;
                this.first = first;
                this.last = this.first;
            }else{
                this.size = 2;
                this.first = first;
                this.last = last;
            }


        }catch (NullPointerException e){}

    }


    @Override
    public void append(DequeNode node) {
        if (this.first == null) {
            this.first = node;
            this.size = 1;
        } else {
            this.last.setNext(node);
            node.setPrevious(this.last);
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
            node.setNext(this.first);
            this.size++;
        }
        this.first = node;

    }

    @Override
    public void deleteFirst() {
        if (size() == 0) {
            throw new RuntimeException("Empty list");
        } else {
            if (size == 1) {
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
            throw new RuntimeException("Empty list");
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
            throw new RuntimeException("Empty list");
        } else {
            node = this.first;
        }
        return node;
    }

    @Override
    public DequeNode peekLast() {
        DequeNode node;
        if (this.size == 0) {
            throw new RuntimeException("Empty list");
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
                throw new RuntimeException("Empty list");
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
            throw new RuntimeException("Empty list");
        } else {
            node = this.first;
            while ((node != null) && !(node.getItem().equals(item))) {
                node = node.getNext();
            }

            if(node == null)
                throw new RuntimeException("Item not found");

        }
        return node;
    }

    @Override
    public void delete(DequeNode node) {
        if (this.size == 0) { //La cola esta vacia
            throw new RuntimeException("Empty list");
        } else { // La cola no esta vacia
            DequeNode aux = this.first;
            int i = 0;
            while (!(aux.getItem().equals(node.getItem())) && i < this.size) { // Busco si el nodo se encuentra en la cola
                aux = aux.getNext();
                i++;
            }

            if(aux != null){ // El nodo está en la cola
                if(aux == this.first){ // Elimino el primer nodo
                    this.deleteFirst();
                }else if(aux == this.last){ // Elimino el ultimo nodo
                    this.deleteLast();
                }else{ // Elimino un nodo intermedio
                    aux.getNext().setPrevious(aux.getPrevious());
                    aux.getPrevious().setNext(aux.getNext());
                    size--;
                }
            }else{ // El nodo no está en la cola
                throw new RuntimeException("Node not in the list");
            }
        }
    }

    @Override
    public void sort(Comparator comparator) {

    }
}






