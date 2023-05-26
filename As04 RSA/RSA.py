def gcd(a, b):  # calculates GCD of a and d
    while b != 0:
        c = a % b
        a = b
        b = c
    return a


def modinv(a, m):  # calculates modulo inverse of a for
    for x in range(1, m):
        if (a * x) % m == 1:
            return x
    return None


def coprimes(a):  # calculates all possible co-prime numbers
    l = []
    
    for x in range(2, a):
        if gcd(a, x) == 1 and modinv(x, phi) != None:
            l.append(x)
    
    for x in l:
        if x == modinv(x, phi):
            l.remove(x)
   
    return l


def encrypt_block(m):  # encrypts a single block
    c = m ** e % n     # msg^e mod n
    return c


def decrypt_block(c):  # decrypts a single block
    m = c ** d % n
    return m


def encrypt_string(s):  # applies encryption
    return ''.join([chr(encrypt_block(ord(x))) for x in list(s)])


def decrypt_string(s):  # applies decryption
    return ''.join([chr(decrypt_block(ord(x))) for x in list(s)])


if __name__ == "__main__":
    
    #step 1 : select prime p & q
    p = int(input('Enter prime p: '))
    q = int(input('Enter prime q: '))
    print("Choosen primes:\np=" + str(p) + ", q=" + str(q) + "\n")
    
    #step2 : calculate n = p x q; 
    n = p * q
    print("n = p * q = " + str(n) + "\n")
   
    
    #step 3 : calculate phi(n) i.e. (p-1) x (q-1)
    phi = (p - 1) * (q - 1)
    print("Euler's function (totient) [phi(n)]: " + str(phi) + "\n")
    
    
    # step 4 : select "e" accordingly i.e. gcd(e, phi)==1
    print("Choose an e from a below coprimes array:\n")
    print(str(coprimes(phi)) + "\n")
    e = int(input())
    #we got our public key(n, e)
   
    # for private k 
    # step 5 : calculate d : (d x e) mod(phi)==1
    d = modinv(e, phi)  # calculates the decryption key d
    
    
    print("\nYour public key is a pair of numbers (e=" +
          str(e) + ", n=" + str(n) + ").\n")
    print("Your private key is a pair of numbers (d=" + str(d) + ", n=" +
          str(n) + ").\n")
    
    
    s = input("Enter a message to encrypt: ")
    print("\nPlain message: " + s + "\n")
    
    
    enc = encrypt_string(s)
    print("Encrypted message: ", enc, "\n")
    
    dec = decrypt_string(enc)
    print("Decrypted message: " + dec + "\n")
