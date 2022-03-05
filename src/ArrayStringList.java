package cs1302.p2;

import cs1302.p2.BaseStringList;
import cs1302.adt.FancyStringList;
import cs1302.adt.StringList;

/**
 * ArrayStringList is a child class of BaseStringList and uses its methods.
 */
public class ArrayStringList extends BaseStringList {

    private String[] items;

    /**
     * Creates a new ArrayStringList object and extends to the parent for size
     * as well as initializing items array.
     */
    public ArrayStringList() {
        super();
        items = new String[size()];
    } // ArrayStringList

    /**
     * Creates a new ArrayStringList object that copies the items from the StringList.
     *
     * @param other  the inputted StringList to be copied to new list
     * @throws NullPointerException if 'other' is null
     */
    public ArrayStringList(StringList other) throws NullPointerException {
        super();
        if (other == null) {
            throw new NullPointerException("The list to be added must not be null.");
        } // if
        this.size = other.size();
        this.items = new String[size()];
        for (int i = 0; i < items.length; i++) {
            this.items[i] = other.get(i);
        } // for
    } // ArrayStringList

    /**
     * Adds an inputted String item at specified index in the array list.
     *
     * @param item  inputted String
     * @param index  specified position for item
     * @return true if successfully added
     * @throws IndexOutOfBoundsException if the index given is not valid in list
     * @throws IllegalArgumentException if item is empty
     * @throws NullPointerException if item is equal to null
     */
    public boolean add(int index, String item) throws IndexOutOfBoundsException,
        NullPointerException, IllegalArgumentException {

        if (item == null) {
            throw new NullPointerException("The item must not be null");
        } else if (item.length() == 0) {
            throw new IllegalArgumentException("The item must not be empty");
        } else if (!(isInBoundsExclusive(index))) {
            throw new IndexOutOfBoundsException("Must choose a valid index");
        } // else

        String[] tempArr;
        if (size()  >= items.length) {
            tempArr = new String[((3 * (items.length)) / 2) + 3];
        } else {
            tempArr = new String[items.length];
        } // else

        for (int i = 0; i < items.length; i++) {
            tempArr[i] = items[i]; //!!!
        } // for
        for (int i = tempArr.length - 1; i > index; i--) {
            tempArr[i] = tempArr[i - 1];
        } // for
        tempArr[index] = item;
        items = tempArr;
        size++;
        return true;
    } // add

    /**
     * Clears all items from the list.
     */
    @Override
    public void clear() {
        String[] tempArr = new String[0];
        items = tempArr;
        size = 0;
    } // clear

    /**
     * Gets the item at specified index of the list.
     *
     * @param index of desired item
     * @return the String of item gotten
     * @throws IndexOutOfBoundsException if index is not between zero and size
     */
    public String get(int index) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Cannot get an item from an empty list");
        } else if (!(isInBounds(index))) {
            throw new IndexOutOfBoundsException("Must choose a valid index");
        } // else

        return items[index];
    } // get

    /**
     * Removes an item from the list at given index.
     *
     * @param index to remove item
     * @return the item removed
     * @throws IndexOutOfBoundsException if index is not between zero and size
     */
    public String remove(int index) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Cannot get an item from an empty list");
        } else if (!(isInBounds(index))) {
            throw new IndexOutOfBoundsException("Must choose a valid index");
        } // if
        String deleted = items[index];
        String[] tempArr = new String[size() - 1];
        for (int i = 0; i < index; i++) {
            tempArr[i] = items[i];
        } // for
        for (int i = index; i < size() - 1; i++) {
            tempArr[i] = items[i + 1];
        } // for
        items = tempArr;
        size--;
        return deleted;
    } // remove

    /**
     * Creates a new StringList object and the values between start and stop are
     * added to the new list.
     *
     * @param start  beginning index
     * @param stop  ending index but does include item at stop
     * @return StringList created
     * @throws IndexOutOfBoundsException if start or stop are not between zero and size
     * or start is greater than stop
     */
    @Override
    public StringList slice(int start, int stop) throws IndexOutOfBoundsException {
        if (start > stop) {
            throw new IndexOutOfBoundsException("Start must not be greater than stop");
        } // if
        StringList slicedList = new ArrayStringList();
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
        FancyStringList slicedList = new ArrayStringList();
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
        FancyStringList rev = new ArrayStringList();
        for (int i = 0; i < size; i++) {
            rev.prepend(get(i));
        } // for
        return rev;
    } // reverse
} // ArrayStringList
