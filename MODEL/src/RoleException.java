package MODEL.src;
import CONTROLLER.src.*;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//                DEADWOOD - ROLE EXCEPTION CLASS                       //
//  Programmers: Vlad Bugayev, Natthapong Choeypant                         //
//  Class: CSCI 345, Summer 2019                                            //
//                                                                          //
//                                                                          //
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

// Define a role exception - occurs when a player tries to take invalid role
public class RoleException extends Exception {
    private Controller observer;
    public RoleException(){
        super("Invalid Role");
    }
}
