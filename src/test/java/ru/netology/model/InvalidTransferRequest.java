package ru.netology.model;

import lombok.Value;

@Value
public class InvalidTransferRequest {
    Object from;
    Object to;
    Object amount;
}
