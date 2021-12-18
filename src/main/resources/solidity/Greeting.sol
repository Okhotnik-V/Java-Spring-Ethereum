//SPDX-License-Identifier: MIT
pragma solidity ^0.6.11;

contract Greeting {
    string public hello = "Hello World";

    function getHello() public view returns(string memory) {
        return hello;
    }

    function setHello(string memory newHello) public {
        hello = newHello;
    }
}
