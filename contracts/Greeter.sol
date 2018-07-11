pragma solidity ^0.4.19;

contract Greeter {
    string greeting;

    constructor() public {
        greeting = "Hello World!";
    }

    function greet() public view returns (string) {
        return greeting;
    }
}