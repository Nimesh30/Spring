import { Routes, Route } from "react-router-dom";
import StudentList from "./components/StudentList";
import StudentForm from "./components/StudentForm";

function App() {
  return (
    <div>
      <h1 align="center">Student Management System</h1>

      <Routes>
        <Route path="/" element={<StudentList />} />
        <Route path="/add-student" element={<StudentForm />} />
        <Route path="/edit-student/:id" element={<StudentForm />} />
      </Routes>
    </div>
  );
}

export default App;
