#!/usr/bin/env python3

import json
import sys

def expand(value):
  """Expands a stringly-typed number into double digits if necessary"""
  if len(value) == 1:
    return f"0{value}"
  return value

# Avoid calculating on each run by keeping
# a list of commonly found transparencies.
transparency_map = {
  100: 'FF',
  75:  'BF',
  60:  '99',
  45:  '73',
  30:  '4D',
  15:  '26',
  5:   '0D',
}

if len(sys.argv) != 2:
  print("Usage:\n ./generate_colors_xml.py <tokens.json>")
  exit(255)

f = open(sys.argv[1],)
js = json.load(f)
for key, value in js['tokens']['colors'].items():
  # Convert each input value to hex, strip out the leading 0x
  # and convert to upper case.
  r = expand(hex(value[0]).replace('0x', '').upper())
  g = expand(hex(value[1]).replace('0x', '').upper())
  b = expand(hex(value[2]).replace('0x', '').upper())
  # Convert ]0,1[ ranged alphas to ]0,100[ and fetch
  # hex from our map.
  a = transparency_map[value[3] * 100]
  print(f'<color name="{key}">#{a}{r}{g}{b}</color>')
