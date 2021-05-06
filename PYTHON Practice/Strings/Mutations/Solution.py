def mutate_string(string, position, character):
    chars = list(string)
    chars[position] = character
    return "".join(chars)


