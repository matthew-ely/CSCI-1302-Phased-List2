package cs1302.p2;

import cs1302.adt.FancyStringList;
import cs1302.adt.StringList;

/**
 * BaseStringList implements StringList interface and contains
 * helper methods used by child classes and driver classes.
 */
public abstract class BaseStringList implements FancyStringList {

    protected int size;

    /**
     * Creates a BaseStringList object and sets the size to zero.
     */
    public BaseStringList() {
        this.size = 0;
    } // BaseStringList

    /**
     * Appends an item to the string list at index equalling size.
     *
     * @param item  String containing item to store
     * @return adds item to list at index equalling size
     */
    @Override
    public boolean append(String item) {
        return this.add(size, item);
    } // append

    /**
     * Appends a StringList item to the list at index equalling size.
     *
     * @param items  StringList containing items to store
     * @return true  when items are added to the list at index equalling size
     */
    @Override
    public boolean append(StringList items) {
        return this.add(size, items);
    } // append

    /**
     * Returns true if this string list has no items.
     * More formally, a string list is empty if, and only if, its size is zero.
     *
     * @return true if size = 0 and false otherwise
     */
    @Override
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        } else {
            return false;
        } // else
    } // isEmpty

    /**
     * Returns a string representation of this string list that
     * begins with start and ends with end, with every string in the string list by sep.
     *
     * @param start  the starting character
     * @param sep  the separating character
     * @param end  the ending character
     * @return a string containing items with proper start,sep,end characters
     */
    @Override
    public String makeString(String start, String sep, String end) {
        if (isEmpty()) {
            return start + end;
        } // if
        String fancyString = start;
        for (int i = 0; i < size() - 1; i++) {
            fancyString += get(i) + sep;
        } // for
        fancyString += get(size() - 1) + end;
        return fancyString;
    } // makeString

    /**
     * Prepends an item to the string list at index 0. If an item was already at that position,
     * then that item and subsequent items are shifted to the right
     *
     * @param item  String containing item to store
     * @return adding an item and index 0
     */
    @Override
    public boolean prepend(String item) {
        return this.add(0, item);
    } // prepend

    /**
     * Prepends the StringList items to the list at index 0. If an item was already in that
     * position, then that item and subsequent items are shifted to the right
     *
     * @param items  StringList containing items to store
     * @return true  when items are added at index 0
     */
    @Override
    public boolean prepend(StringList items) {
        return this.add(0, items);
    } // prepend

    /**
     * Returns the number of items in string list.
     *
     * @returns number of items in list
     */
    @Override
    public int size() {
        return this.size;
    } // size

    /**
     * Returns a makeString with start: "[", sep: ",", end: "]".
     *
     * @return makeString("[", ", ", "]")
     */
    @Override
    public String toString() {
        return makeString("[", ", ", "]");
    } // toString

    /**
     * Determines if an index is within the list's boundaries including the last item.
     *
     * @param a  int value of index
     * @return false  if not in bounds and true if in bounds
     */
    public boolean isInBounds(int a) {
        if ((a < 0) || (a >= size)) {
            return false;
        } else {
            return true;
        } // if
    } // isInBounds

    /**
     * Determines if an index is within the list's boundaries excluding the last item.
     *
     * @param a  int value of index
     * @return false  if not in bounds and true if in bounds
     */
    public boolean isInBoundsExclusive(int a) {
        if ((a < 0) || (a > size)) {
            return false;
        } else {
            return true;
        } // if
    } // isInBoundsExclusive

    /**
     * Uses indexOf method to determine if a target string is contained in a list at
     * after a certain index. Returns true if in the list, false otherwise.
     *
     * @param start  starting index
     * @param target  target string to see if contained
     * @return true  if it contained in the list after ceratin index, false otherwise
     */
    @Override
    public boolean contains(int start, String target) {
        if (!isInBoundsExclusive(start)) {
            return false;
        } // if
        if (indexOf(start, target) >= 0) {
            return true;
        } else {
            return false;
        } // else
    } // contains

    /**
     * Loops through the list and determines if a target string is contained in
     * the list and returns index in list of that value.
     *
     * @param start  starting index
     * @param target  target string to find index of
     * @return int value  of index of string item, '-1' if not in list
     */
    @Override
    public int indexOf(int start, String target) {
        if (!isInBoundsExclusive(start)) {
            return -1;
        } // if
        for (int i = start; i < size; i++) {
            if (get(i).equals(target)) {
                return i;
            } // if
        } // for
        return -1;
    } // indexOf

    /**
     * Adds the items of the StringList to the list at given index.
     *
     * @param index  index in list to insert item(s)
     * @param items  StringList of items to add
     * @return true  when items are successfully added to the list
     * @throws IndexOutOfBoundsException  when the index is not within list's bounds
     * @throws NullPointerException  when the StringList is null
     */
    @Override
    public boolean add(int index, StringList items) {
        if (!isInBounds(index)) {
            throw new IndexOutOfBoundsException("The index must be valid and within bounds.");
        } else if (items == null) {
            throw new NullPointerException("The StringList must not be null!");
        } // if
        boolean j = false;
        if (this.size() != items.size()) {
            j = true;
        } else {
            for (int i = 0; i < items.size(); i++) {
                if (!(items.get(i).equals(this.get(i)))) {
                    j = true;
                } // if
            } // for
        } // if
        if (j) {
            for (int i = 0; i < items.size(); i++) {
                add(index + i, items.get(i));
            } // for
        } else {
            String[] temp = new String[size()];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = items.get(i);
            } // for
            for (int i = 0; i < temp.length; i++) {
                add(index + i, temp[i]);
            } // for
        } // if
        return true;
    } // add
} // BaseStringList
