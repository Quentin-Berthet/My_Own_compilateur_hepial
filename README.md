# TP Hepial
Création du langage de programmation Hepial via JFlex/Cup/Jasmin.

## Pré-requis
* Ant
    * macOS : `brew install ant`
    * GNU/Linux : `apt install ant`

## Construire le projet
* Cloner le projet `git clone ssh://git@ssh.hesge.ch:10572/baptiste.coudray/tp_hepial.git`
* Naviguez dans le dossier du projet `cd tp_hepial`
* Exécuter `ant hepial`
* Cela va compiler le fichier demo1.hepial définit dans le fichier [build](build.xml)
* Pour changer de fichier source, modifier dans le fichier `build.xml`
    * à la ligne 43, le nom du fichier Hepial (ex: `demo2.hepial`)
    * à la ligne 52, le nom du fichier qui sera généré par Jasmin (ex: `demo2.j`)
    * à la ligne 57, le nom du programme Hepial (ex: `Demo2`)
