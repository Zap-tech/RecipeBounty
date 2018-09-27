pragma solidity ^0.4.24;

import "./TasteLibrary.sol";

contract CustomerFactory {
    event CreateCustomer(address _address);
    
    struct Customer {
        Taste.TastePreference taste_preference;
    }
    
    Customer[] customer_listing;
    mapping(address => uint) customer_mapping;
    
    function createCustomer(address _address, Taste.TastePreference _pref) internal {
        require(customer_mapping[_address] == 0, "Given address is already a customer.");
        
        Customer memory customer = Customer({
            taste_preference: _pref
        });
        
        customer_listing.push(customer);
        customer_mapping[_address] = customer_listing.length;
        
        emit CreateCustomer(_address);
    }
    
    function hasCustomer (address _address) public view returns(bool) {
        return customer_mapping[_address] != 0;
    }
    
    function getCustomer (address _address) public view returns(Taste.TastePreference) {
        require(customer_mapping[_address] != 0, "Given Customer does not exist");
        Customer memory customer = customer_listing[customer_mapping[_address]-1];
        return customer.taste_preference;
    }
}
