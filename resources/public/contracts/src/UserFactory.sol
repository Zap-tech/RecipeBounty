pragma solidity ^0.4.24;

contract UserFactory {
    event CreateUser(address _address);
    
    struct User {
      string name;
      string email;    
    }
    
    User[] user_listing;
    mapping(address => uint) user_mapping;
    
    function createUser(address _address, string _name, string _email) internal {
        require(user_mapping[_address] == 0, "User with given address already exists.");
        assert(bytes(_name).length > 0);
        assert(bytes(_email).length > 0);
        
        User memory user = User({
            name: _name,
            email: _email
        });
        
        user_listing.push(user);
        user_mapping[_address] = user_listing.length;
        
        emit CreateUser(_address);
    }
    
    function hasUser(address _address) public view returns (bool) {
        return user_mapping[_address] != 0;
    }
    
    function getUser(address _address) public view returns (string, string) {
        require(user_mapping[_address] != 0, "User with given address does not exist.");
        User memory user = user_listing[user_mapping[_address]-1];
        return (user.name, user.email);
    }
    
    function getCurrentUser() public view returns (string, string) {
        require(user_mapping[msg.sender] != 0, "Current user does not exist.");
        return getUser(msg.sender);
    }
}
