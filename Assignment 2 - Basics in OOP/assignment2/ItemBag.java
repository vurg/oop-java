package assignment2;

import java.util.ArrayList;

public class ItemBag {
    private final double MAX_WEIGHT;
    private double currentWeight;
    private ArrayList<Item> itemList;

    public ItemBag(double maxWeight){
        this.MAX_WEIGHT = maxWeight;
        this.currentWeight = 0.0;
        this.itemList = new ArrayList<>();
    }

    //behavior adds item (if it does not exceed max weight of bag), returns index of added item (returns -1 if cannot add item)
    public int addItem(Item item){

        int currentIndex = -1;

        if((item.getWeight() + this.currentWeight) <= this.MAX_WEIGHT) {
            this.itemList.add(item);
            this.currentWeight = this.currentWeight + item.getWeight();
            currentIndex = sortAddedItem(item);
        }
        return currentIndex;
    }

    //sorts the bag by weight (largest to smallest) after new item has been added
    private int sortAddedItem(Item item){

        int itemIndex = this.itemList.size()-1;

        for(int i = this.itemList.size() - 2; i >= 0; i--) {
            double weightCurrentItem = this.itemList.get(i).getWeight();

            if(item.getWeight() >= weightCurrentItem) {
                this.itemList.set(i + 1, this.itemList.get(i));
                itemIndex = i;
            }
        }
        this.itemList.set(itemIndex, item);

        return itemIndex;
    }

    //returns toString of item at position index (returns empty string if out of bounds)
    public String peekItemAt(int index){

        String message = "";

        if(index < 0 || index > this.itemList.size()-1){
            //do nothing.
        }else{
            Item itemAtIndex = itemList.get(index);
            message = itemAtIndex.toString();
        }
        return message;
    }

    //removes item at index position, returns reference of Item to user (returns null if out of bounds)
    public Item removeItemAt(int index) {

        Item itemAtIndex = null;

        if(index < 0 || index > this.itemList.size()-1){
            //return null;
        }else{
            itemAtIndex = this.itemList.get(index);
            itemList.remove(index);
            this.currentWeight = this.currentWeight - itemAtIndex.getWeight();
        }
        return itemAtIndex;
    }

    // Removes item at index position 0 and returns to user (returns null if bag is empty)
    public Item popItem(){

        Item poppedItem = removeItemAt(0);
        return poppedItem;
    }

    //getter methods
    public double getMaxWeight(){return this.MAX_WEIGHT;}
    public double getCurrentWeight(){return this.currentWeight;}
    public int getNumOfItems(){return this.itemList.size();}

}
