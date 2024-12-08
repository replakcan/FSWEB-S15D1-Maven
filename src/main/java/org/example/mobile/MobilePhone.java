package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {

    private String myNumber;
    private List<Contact> myContacts = new ArrayList<>();

    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        this.myContacts = contacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (!myContacts.contains(contact)){
            myContacts.add(contact);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateContact(Contact prev, Contact toCompare) {
        if (myContacts.contains(prev)) {
            myContacts.set(myContacts.indexOf(prev), toCompare);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact) {
        if (myContacts.contains(contact)) {
            myContacts.remove(contact);
            return true;
        }
        return false;
    }

    public int findContact(Contact contact) {
        return myContacts.contains(contact) ? myContacts.indexOf(contact) : -1;
    }

    public int findContact(String contactName) {
        int i = 0;

        while (i < myContacts.size()){
            if (myContacts.get(i).getName() == contactName) {
                return i;
            } else {
                i++;
            }
        }
        return -1;
    }

    public Contact queryContact(String contactName) {
        int i = 0;

        while (i < myContacts.size()){
            if (myContacts.get(i).getName() == contactName) {
                return myContacts.get(i);
            } else {
                i++;
            }
        }
        return null;
    }

    public void printContact() {
        System.out.println(myContacts);
    }
}
