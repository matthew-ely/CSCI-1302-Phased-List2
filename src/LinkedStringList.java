package cs1302.p2;

import cs1302.p2.BaseStringList;
import cs1302.adt.Node;
import cs1302.adt.StringList;
import cs1302.adt.FancyStringList;

/**
 * Linked StringList is a child class of BaseStringList and uses its methods.
 */
public class LinkedStringList extends BaseStringList {

    private Node head;

    /**
     * Creates a new LinkedStringList object and extends to the parent for size.
     */
    public LinkedStringList() {
        super();
    } // LinkedStringList

    /**
     * Creates a new LinkedStringList object that copies the items from the StringList.
     *
     * @param other  the inputted StringList to be copied to new list
     * @throws NullPointerException if 'other' is null
     */
    public LinkedStringList(StringList other) throws NullPointerException {
        super();
        if (other == null) {
            throw new NullPointerException("The list to add must not be null.");
        } // if
        for (int i = 0; i < other.size(); i++) {
            add(i, other.get(i));
        } // for

    } // LinkedStringList

    /**
     * Adds an inputted String item at specified index in the linked list.
     *
     * @param item  inputted String
     * @param index  specified position for item
     * @return true  if successfully added
     * @throws IndexOutOfBoundsException if the index given is not valid in list
     * @throws IllegalArgumentException if item is empty
     * @throws NullPointerException if item is equal to null
     */
    public boolean add(int index, String item) throws IndexOutOfBoundsException,
        IllegalArgumentException, NullPointerException {

        if (item == null) {
            throw new NullPointerException("The item must not be null");
        } else if (item.length() == 0) {
            throw new IllegalArgumentException("The item must not be empty");
        } else if (!(isInBoundsExclusive(index))) {
            throw new IndexOutOfBoundsException("Must choose a valid index");
        } // else

        if (isEmpty()) {
            head = new Node(item);
        } else if (index == 0) {
            head = new Node(item, head);
        } else {
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.getNext();
            } // for
            temp.setNext(new Node(item, temp.getNext()));
        } // else
        size++;
        return true;
    } // add

    /**
     * Clears all items from the list.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    } // clear

    /**
     * Gets the item at specified index of the list.
     *
     * @param index of desired item
     * @return  the String of item gotten
     * @throws IndexOutOfBoundsException if index is not between zero and size
     */
    public String get(int index) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Cannot get an item from an empty list");
        } else if (!(isInBounds(index))) {
            throw new IndexOutOfBoundsException("Must choose a valid index");
        } // if
        String getResult;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        } // for
        getResult = temp.getItem();
        return getResult;
    } // get

    /**
     * Removes an item from the list at given index.
     *
     * @param index to remove item
     * @return  the item removed
     * @throws IndexOutOfBoundsException if index is not between zero and size
     */
    public String remove(int index) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Cannot get an item from an empty list");
        } else if (!(isInBounds(index))) {
            throw new IndexOutOfBoundsException("Must choose a valid index");
        } // if
        String removed = "";
        if (index == 0) {
            removed = head.getItem();
            head = head.getNext();
        } else {
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.getNext();
            } // for
            removed = temp.getNext().getItem();
            temp.setNext(temp.getNext().getNext());
        } // else
        size--;
        return removed;
    } // remove

    /**
     * Creates a new StringList object and the values between start and stop are
     * added to the new list.
     *
     * @param start beginning index
     * @param stop  ending index but does include item at stop
     * @return  StringList created
     * @throws IndexOutOfBoundsException if start or stop are not between zero and size
     * or start is greater than stop
     */
    @Override
    public StringList slice(int start, int stop) throws IndexOutOfBoundsException {
        if (start > stop) {
            throw new IndexOutOfBoundsException("Start must not be greater than stop");
        } // if
        StringList slicedList = new LinkedStringList();
        for (int i = start; i < stop; i++) {
            slicedList.append(get(i));
        } // for
        return slicedList;
    } // slice

    /**
     * Creates a new FancyStringList with select items from the starting index to the ending
     * index stepping by the step int value. (if step is 2 it steps over one item at a time.)
     *
     * @param start  beginning index
     * @param stop  ending index but does not include item at stop
     * @param step  step - 1 the amount of objets to skip over before being added
     * @return FancyStringList created
     * @throws IndexOutOfBoundsException if start of stop are not between zero and size
     * or start is greater than stop or step is less than 1
     */
    @Override
    public FancyStringList slice(int start, int stop, int step) throws IndexOutOfBoundsException {
        if (start > stop) {
            throw new IndexOutOfBoundsException("Start must not be greater than stop");
        } else if (step < 1) {
            throw new IndexOutOfBoundsException("Step must be 1 or greater");
        } // if
        FancyStringList slicedList = new LinkedStringList();
        for (int i = start; i < stop; i += step) {
            slicedList.append(get(i));
        } // for
        return slicedList;
    } // slice

    /**
     * Creates a FancyStringList that takes the items in the list and displays them
     * in reverse order.
     *
     * @return FancyStringList  of items in reverse order
     */
    @Override
    public FancyStringList reverse() {
        FancyStringList rev = new LinkedStringList();
        for (int i = 0; i < size; i++) {
            rev.prepend(get(i));
        } // for
        return rev;
    } // reverse

} // BaseStringList
