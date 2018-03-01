const fs = require('fs');

const path = './';

fs.readdir(path, (err, files) => {
  files.forEach(file => {
	  const newFile = (file.trim().charAt(0).toUpperCase() + file.trim().slice(1))
	   .replace(/(\.\.)/g,'.')
	   .replace(/(\s+)/g,' ')
	   .replace(/№(\d)/g,'№ $1')
       .replace(/(\s)(\d)([\D]+\.)/,'$10$2$3')
	   ;
	   
	   console.log(path+file,'-', newFile);
	   fs.renameSync(path+file, path+newFile);
  });
})