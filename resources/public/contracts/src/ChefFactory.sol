pragma solidity ^0.4.24;

contract ChefFactory {
    event CreateChef(address _address);
    
    struct Chef {
        uint8 cooking_ability; // Personal Cooking Rating 1-10
        uint8 baddaboops;      // Acquired Taste Rating 1-10
    }
    
    Chef[] chef_listing;
    mapping(address => uint) chef_mapping;
    
    function createChef(address _address, uint8 _cooking_ability) internal {
        require(chef_mapping[_address] == 0, "Chef for that address already exists.");
        assert(_cooking_ability >= 1 && _cooking_ability <= 10);
        
        Chef memory chef = Chef({
            cooking_ability: _cooking_ability,
            baddaboops: 1
        });
        
        chef_listing.push(chef);
        chef_mapping[_address] = chef_listing.length;
        
        emit CreateChef(_address);
    }
    
    function hasChef(address _address) public view returns(bool) {
        return chef_mapping[_address] != 0;
    }
    
    function getChef(address _address) public view returns (uint8, uint8) {
        require(chef_mapping[_address] != 0, "Chef with given address does not exist.");
        Chef memory chef = chef_listing[chef_mapping[_address]-1];
        return (chef.cooking_ability, chef.baddaboops);
    }
    
    function getCurrentChef() public view returns (uint8, uint8) {
        return getChef(msg.sender);
    }
}
