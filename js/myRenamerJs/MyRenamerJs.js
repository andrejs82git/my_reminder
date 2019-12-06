const fs = require('fs');

const path = './';

fs.readdir(path, (err, files) => {
  files.forEach(file => {
	  const newFile = (file.trim().charAt(0).toUpperCase() + file.trim().slice(1))
	   .replace(/(\.\.)/g,'.')
	   .replace(/№/g,' ')
	   .replace(/\s+(\.)/g,'.')
	   .replace(/(\s+)/g,' ')
	   
	   .replace(/(\D)(\d{1,2}(\.|\s))/g,'$1№$2')
	   .replace(/(№)\s?(\d)/g,'$1$2')
	   
       .replace(/(№)(\d)([\D]+)/,'$10$2$3')
	   ;
	   
	   console.log(`${path+file} \t ${newFile}`);
	   fs.renameSync(path+file, path+newFile);
  });
})