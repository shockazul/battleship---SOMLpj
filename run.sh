# ! /bin/bash
echo "Installing some stuff... This may take a minute :/"
sudo apt update 
echo "Don't worry, we're still here!"
sudo apt upgrade 
command -v git > /dev/null
if [ $? -eq 0 ] 
then
	echo "Git is already installed..."
else 
	echo "Installing Git"
    sudo apt install git 
fi

if [ -d ./Battleship ]
then
    echo "Battleship repository has already been cloned..."
else
    git clone https://github.com/SOMLpj/Battleship.git
fi

cd Battleship
sudo apt-get update -y && sudo apt-get install -y linux-image-extra-$(uname -r)
command -v docker > /dev/null
if [ $? -eq 0 ] 
then
	echo "Docker already installed..."
else 
	echo "Installing Docker"
    sudo apt-get install docker-engine -y 
    echo "Docker is installed!"
fi

sudo groupadd docker
sudo usermod -aG docker $(whoami)
sudo service docker start
sudo docker run hello-world 

docker build -t battleship .
clear
echo "We're ready for you now!"
sleep 1s
clear
docker run -it battleship





