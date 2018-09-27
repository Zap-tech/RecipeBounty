pragma solidity ^0.4.24;

import "./TasteLibrary.sol";

// Customers Open a bounty, multiple chefs can draft solutions
// TasteTesters test out drafts and rate them.
// Customer can then claim what they deem the 'best',
// and the Chef who is claimed is rewarded.
contract RecipeBountyFactory {
    
    struct RecipeBounty {
        string name;
        string description;
        uint256 reward;
    }
    
    RecipeBounty[] recipe_listing;
    mapping(address => uint) recipe_mapping;
    // ...
    
}
