# Consul

## Instalation on Ubuntu

    sudo apt-add-repository "deb [arch=amd64] https://apt.releases.hashicorp.com $(lsb_release -cs) main"
    sudo apt-get update && sudo apt-get install consul

## Execution in Dev Mode

    consul agent -dev
