#!/bin/bash

args=(1 2 3 4 5 99 13 87 43 43)

if (($# < 2)); then
  echo "Number of input arguments is less then 2! Default array is used: ${args[*]}"
  else
    args=($@)
fi

find_maximums() {
  declare -a array=("${@}")

  local -i first_maximum=-2147483648
  local -i second_maximum=-2147483648

  for i in "${array[@]}" ; do
      if ((i>first_maximum)); then
          second_maximum=first_maximum
          first_maximum=i
          else
            if ((i<first_maximum && i>second_maximum)); then
              second_maximum=i
            fi
      fi
  done

  if ((second_maximum == -2147483648)); then
      printf "%s\n" "There is no second largest number in array." \
                "Or array contains minimal integer value: -2147483648." \
                "Or it contains only duplicates." \
                "Please try again with another input!"

      exit 1
  fi

  echo "First maximum is: $first_maximum"
  echo "Second maximum is: $second_maximum"
}

find_maximums "${args[@]}"
