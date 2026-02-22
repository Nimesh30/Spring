export function validateStudentForm(student) {

    console.log("In validation....");
    
    const {
      firstName,
      lastName,
      email,
      dob,
      admissionDate,
      city,
      stateCode,
      country,
    } = student;
  
    // First name max 50
    if (!firstName || firstName.trim().length > 50) {
      alert("First name is required and must be max 50 characters");
      return false;
    }
  
    // Last name max 50
    if (lastName && lastName.trim().length > 50) {
      alert("Last name must be max 50 characters");
      return false;
    }
  
    // Email pattern
    const emailPattern =
      /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  
    if (!emailPattern.test(email)) {
      alert("Please enter a valid email address");
      return false;
    }
  
    // DOB required
    if (!dob) {
      alert("Date of Birth is required");
      return false;
    }
  
    const dobDate = new Date(dob);
    const today = new Date();
  
    let age = today.getFullYear() - dobDate.getFullYear();
    const m = today.getMonth() - dobDate.getMonth();
  
    if (m < 0 || (m === 0 && today.getDate() < dobDate.getDate())) {
      age--;
    }
  
    if (age < 18) {
      alert("Student age must be 18 or above");
      return false;
    }
  
    // Admission date required
    if (!admissionDate) {
      alert("Admission date is required");
      return false;
    }
  
    const admission = new Date(admissionDate);
  
    if (admission < dobDate) {
      alert("Admission date cannot be before Date of Birth");
      return false;
    }
  
    // if (admission > today) {
    //   alert("Admission date cannot be in the future");
    //   return false;
    // }
  
    // City only characters
    if (!/^[a-zA-Z\s]+$/.test(city)) {
      alert("City must contain only characters");
      return false;
    }
  
    // State code exactly 2 characters
    if (!stateCode || stateCode.length !== 2) {
      alert("State code must be exactly 2 characters");
      return false;
    }
  
    // Country only characters
    if (!/^[a-zA-Z\s]+$/.test(country)) {
      alert("Country must contain only characters");
      return false;
    }
  
    return true;
  }
  