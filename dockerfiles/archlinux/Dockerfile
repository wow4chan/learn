FROM archlinux/base

RUN pacman -Sy --noconfirm grep ripgrep which sudo fish zsh\
  tar unzip curl wget git subversion gcc make cmake automake\
  mongodb redis python python2 nodejs-lts-dubnium vim emacs-nox\
  && pacman -Scc --noconfirm

LABEL maintainer="winnochan@icloud.com"
LABEL author="winnochan"
LABEL version="0.0.1"

# ARG user
# ARG shell
# ARG workspace

ENV USER wowchan
ENV SHELL /usr/bin/zsh
ENV WORKSPACE /home/${USER}/workspace

# configure the default user and workspace
RUN useradd -m -p ${USER} -s ${SHELL} ${USER}
USER ${USER}

RUN git clone https://github.com/robbyrussell/oh-my-zsh.git ~/.oh-my-zsh
RUN cp ~/.oh-my-zsh/templates/zshrc.zsh-template ~/.zshrc

WORKDIR ${WORKSPACE}

CMD zsh
