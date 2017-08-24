  function hello() {
    window.alert("hello zolika how are you doing?");
  }

  function validateForm(){
      var x = document.forms["myform"]["firstName"].value;

      if (x == "") {
          alert("First name empty");
          return false;
      }

  }