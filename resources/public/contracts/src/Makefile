# Makefile for building solidity contracts

.PHONY: build init clean

SRC_DIR := .
SRC_ABS := $(shell pwd)/$(SRC_DIR)
BUILD_DIR := ../build

SOURCES := $(shell find $(SRC_DIR) -name "*.sol")

BINS := $(SOURCES:.sol=.bin)
ABIS := $(SOURCES:.sol=.abi)


build: init $(BINS) $(ABIS)


init:
	mkdir -p $(BUILD_DIR)


%.bin : %.sol
	solc --overwrite --optimize --bin --allow-paths $(SRC_ABS) $< > $@
	cp $@ $(BUILD_DIR)/$(notdir $@)


%.abi : %.sol
	solc --overwrite --optimize --abi --allow-paths $(SRC_ABS) $< > $@
	cp $@ $(BUILD_DIR)/$(notdir $@)


clean:
	rm -rf $(shell find $(SRC_DIR) -name "*.bin")
	rm -rf $(shell find $(SRC_DIR) -name "*.abi")
	rm -rf $(BUILD_DIR)
