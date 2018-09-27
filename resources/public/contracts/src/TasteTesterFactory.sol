pragma solidity ^0.4.24;

import "./TasteLibrary.sol";

contract TasteTesterFactory {
    event CreateTasteTester(address _address);
    
    struct TasteTester {
        Taste.TastePreference taste_preference;
    }
    
    TasteTester[] tasteTester_listing;
    mapping(address => uint) tasteTester_mapping;
    
    function createTasteTester(address _address) internal {
        require(tasteTester_mapping[_address] == 0, "TasteTester for account already exists.");
        
        TasteTester memory tasteTester = TasteTester({
            taste_preference: Taste.TastePreference.NONE
        });
        
        tasteTester_listing.push(tasteTester);
        tasteTester_mapping[_address] = tasteTester_listing.length;
        
        emit CreateTasteTester(_address);
    }
    
    function hasTasteTester(address _address) public view returns(bool) {
        return tasteTester_mapping[_address] != 0;
    }
    
    function getTasteTester(address _address) public view returns(Taste.TastePreference) {
        require(tasteTester_mapping[_address] != 0, "TasteTester does not exist.");
        TasteTester memory tasteTester = tasteTester_listing[tasteTester_mapping[_address]-1];
        return tasteTester.taste_preference;
    }
    
    function getCurrentTasteTester() public view returns(Taste.TastePreference) {
        return getTasteTester(msg.sender);
    }
}
