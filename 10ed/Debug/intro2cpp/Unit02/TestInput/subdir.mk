################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
D:/cpp/src/Unit02/TestInput/TestInput.cpp 

OBJS += \
./intro2cpp/Unit02/TestInput/TestInput.o 

CPP_DEPS += \
./intro2cpp/Unit02/TestInput/TestInput.d 


# Each subdirectory must supply rules for building sources it contributes
intro2cpp/Unit02/TestInput/TestInput.o: D:/cpp/src/Unit02/TestInput/TestInput.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


