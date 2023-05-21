#!/bin/bash

args=(-25 -14 88 13 0 13 22 16 65 7 43 13)

if (($# < 3)); then
  echo "Number of input arguments is less then 3! Default array is used: ${args[*]}"
else
  args=("$@")
fi

find_maximums() {
  declare -a array=("${@}")

  local -i int_min=-2147483648

  local -i first_maximum=int_min
  local -i second_maximum=int_min
  local -i third_maximum=int_min

  for i in "${array[@]}"; do
    if ((i > first_maximum)); then
      third_maximum=second_maximum
      second_maximum=first_maximum
      first_maximum=i
    elif ((i > second_maximum && i < first_maximum)); then
      third_maximum=second_maximum
      second_maximum=i
    elif ((i > third_maximum && i < first_maximum && i < second_maximum)); then
      third_maximum=i
    fi
  done

  if ((third_maximum == int_min)); then
    printf "%s\n" "There are no there distinct largest numbers in array." \
      "Or array contains minimal integer value: -2147483648." \
      "Or it contains only duplicates." \
      "Please try again with another input!"

    exit 1
  fi

  echo "First largest distinct number is: $first_maximum"
  echo "Second largest distinct number is: $second_maximum"
  echo "Third largest distinct number is: $third_maximum"
}

find_maximums "${args[@]}"
