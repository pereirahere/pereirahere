#imports
import requests
import getpass as gp
from cryptography.fernet import Fernet
from requests.auth import HTTPBasicAuth


local_user = gp.getuser()
url_user = 'https://issues.feedzai.com/rest/api/2/user?username=' + local_user
pw_loc = '/fz/info/jira_pw.txt'


key = Fernet.generate_key()
fernet = Fernet(key)

def fetch_pass():
    global pw
    pw = fernet.encrypt(open(r"/home/" + local_user + pw_loc).readlines()[0].encode())

fetch_pass()

#session = requests.Session()
#session.auth = (local_user, pw)
#auth = session.post(url_user)



r = requests.get(url_user, headers={'content-type: application/json'}, auth=(local_user, fernet.decrypt(pw).decode()))

#curl -s https://issues.feedzai.com/rest/api/2/user?username=joao.pereira -H content-type: application/json -u joao.pereira:password 