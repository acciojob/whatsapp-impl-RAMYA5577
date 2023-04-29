package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class WhatsappRepository {

    //Assume that each user belongs to at most one group
    //You can use the below mentioned hashmaps or delete these and create your own.
    private HashMap<Group, List<User>> groupUserMap;
    private HashMap<Group, List<Message>> groupMessageMap;
    private HashMap<Message, User> senderMap;
    private HashMap<Group, User> adminMap;
    private HashSet<String> userMobile;
    private static int messageId;

    private static int groupCount;
    private Map<String, User> userdb = new HashMap<>();
    private Map<Integer,Message>messageMap;


    public WhatsappRepository() {
        this.groupMessageMap = new HashMap<Group, List<Message>>();
        this.groupUserMap = new HashMap<Group, List<User>>();
        this.senderMap = new HashMap<Message, User>();
        this.adminMap = new HashMap<Group, User>();
        this.userMobile = new HashSet<>();
        this.groupCount = getGroupCount();
        this.messageId = 0;
        this.messageMap = new HashMap<Integer,Message>();
        this.userdb = new HashMap<String, User>();

    }

    public static int getGroupCount() {
        return groupCount;
    }

    public static void setGroupCount(int groupCount) {
        WhatsappRepository.groupCount = groupCount;
    }

    public String createUser(String mobileNumber, String name) throws Exception {
        //If the mobile number exists in database, throw "User already exists" exception
        //Otherwise, create the user and return "SUCCESS"
        if (userMobile.contains(mobileNumber)) {
            throw new Exception("User already exists");
        }
        //userdb.put(mobileNumber,);
        userMobile.add(mobileNumber);
        return "SUCCESS";
    }

    public Group createGroup(List<User> users) {
        // The list contains at least 2 users where the first user is the admin. A group has exactly one admin.
        // If there are only 2 users, the group is a personal chat and the group name should be kept as the name of the second user(other than admin)
        // If there are 2+ users, the name of group should be "Group count". For example, the name of first group would be "Group 1", second would be "Group 2" and so on.
        // Note that a personal chat is not considered a group and the count is not updated for personal chats.
        // If group is successfully created, return group.

        //For example: Consider userList1 = {Alex, Bob, Charlie}, userList2 = {Dan, Evan}, userList3 = {Felix, Graham, Hugh}.
        //If createGroup is called for these userLists in the same order, their group names would be "Group 1", "Evan", and "Group 2" respectively.
        Group group = new Group();
        if (users.size() == 2) {
            group.setName(users.get(1).getName());
            group.setNumberOfParticipants(2);
            groupUserMap.put(group, users);
            adminMap.put(group, users.get(0));
        } else {
            groupCount++;
            group.setName("Group " + groupCount);
            group.setNumberOfParticipants(users.size());
            adminMap.put(group, users.get(0));

        }
        return group;

    }
    public int createMessage(String content) {
        // The 'i^th' created message has message id 'i'.
        // Return the message id.

        Message message=new Message();
        messageId++;
        message.setContent(content);
        message.setId(messageId);
        messageMap.put(messageId,message);
        return messageId;
    }

    public int sendMessage(Message message, User sender, Group group) throws Exception{
        //Throw "Group does not exist" if the mentioned group does not exist
        //Throw "You are not allowed to send message" if the sender is not a member of the group
        //If the message is sent successfully, return the final number of messages in that group.
        int ans = 0;
        for (Group group1:groupUserMap.keySet()){
            if(!groupUserMap.containsKey(group))
                throw new Exception("Group does not exist");
            else {
                if (!groupUserMap.get(group).contains(sender))
                    throw new Exception("You are not allowed to send message");

                else {
                    for (Group group2 : groupMessageMap.keySet()) {
                        if (!groupMessageMap.containsKey(group)) {
                            List<Message> messages = new ArrayList<>();
                            messages.add(message);
                            groupMessageMap.put(group, messages);
                            ans = groupMessageMap.get(group).size();
                        } else {
                            groupMessageMap.get(group).add(message);
                            ans = groupMessageMap.get(group).size();

                        }
                    }

                }

            }}
        return ans;
    }

    public String changeAdmin(User approver, User user, Group group) throws Exception {
        //Throw "Group does not exist" if the mentioned group does not exist
        //Throw "Approver does not have rights" if the approver is not the current admin of the group
        //Throw "User is not a participant" if the user is not a part of the group
        //Change the admin of the group to "user" and return "SUCCESS". Note that at one time there is only one admin and the admin rights are transferred from approver to user.
        for(Group group1: groupUserMap.keySet()){
            if(!groupUserMap.containsKey(group)){
                throw new Exception("Group does not exist");
            }
            else{
                if(!groupUserMap.get(group).contains(user)){
                    throw new Exception("User is not a participant");
                }
            }
        }
        for(User user1:adminMap.values()){
            if(!user1.equals(approver))
                throw new Exception("Approver does not have rights");
            else {
                adminMap.put(group,user);
            }
        }
        return "SUCCESS";
    }

    public int removeUser(User user) throws Exception {
        //This is a bonus problem and does not contains any marks
        //A user belongs to exactly one group
        //If user is not found in any group, throw "User not found" exception
        //If user is found in a group and it is the admin, throw "Cannot remove admin" exception
        //If user is not the admin, remove the user from the group, remove all its messages from all the databases, and update relevant attributes accordingly.
        //If user is removed successfully, return (the updated number of users in the group + the updated number of messages in group + the updated number of overall messages)
        return 1 ;
    }

    public String findMessage(Date start, Date end, int K) throws Exception{
        //This is a bonus problem and does not contains any marks
        // Find the Kth latest message between start and end (excluding start and end)
        // If the number of messages between given time is less than K, throw "K is greater than the number of messages" exception
        return null;

    }
    }
