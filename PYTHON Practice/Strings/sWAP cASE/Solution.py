def swap_case(sentence):
    updated_s = ""
    for c in sentence:
        if c.isupper():
            updated_s += c.lower()
        elif c.islower():
            updated_s += c.upper()
        else:
            updated_s += c
    return updated_s


