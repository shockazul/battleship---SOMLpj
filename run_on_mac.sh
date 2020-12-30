# ! /bin/bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)" brew doctor

brew install git

git clone https://github.com/SOMLpj/Battleship.git

cd battleship

brew cask install docker

docker build -t battleship .

docker run -it battleship