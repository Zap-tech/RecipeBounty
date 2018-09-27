pragma solidity ^0.4.24;

import "./UserFactory.sol";
import "./CustomerFactory.sol";
import "./ChefFactory.sol";
import "./TasteTesterFactory.sol";
import "./TasteLibrary.sol";

contract RecipeExchangeMediator is UserFactory, CustomerFactory,
                                   ChefFactory, TasteTesterFactory
{
    modifier isRegisteredUser(address _address) {
        require(user_mapping[_address] != 0, "User is not Registered.");
        _;
    }
    
    function registerUser(string _name, string _email) public {
        createUser(msg.sender, _name, _email);
    }
    
    
    function registerChef(uint8 _rating) public isRegisteredUser(msg.sender) {
        createChef(msg.sender, _rating);
    }
    
    
    function registerCustomer(Taste.TastePreference _pref) public isRegisteredUser(msg.sender) {
        createCustomer(msg.sender, _pref);
    }
    
    
    function registerTasteTester() public isRegisteredUser(msg.sender) {
        createTasteTester(msg.sender);
    }
}
