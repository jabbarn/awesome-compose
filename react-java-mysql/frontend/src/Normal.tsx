import React, { useEffect, useState } from "react";
import logo from "./logo.svg";
import "./App.css";

type Employee = {
  id: number;
  first_name: string;
  last_name: string;
  birth_date: Date;
  hire_date: Date;
};
type LibraryItem = {
    latest: number;
    name: string;
  };

type Library = {
  results: LibraryItem[];
  total: number;
  available: number;
};

function Normal() {
    const [employees, setEmployees] = useState<Employee[]>();
    const [libraries, setLibraries] = useState<Library[]>();

  useEffect(() => {
    fetch("http://localhost:8086/employees/normal")
      .then(res => res.json())
      .then(setEmployees)
      .catch(console.error);
  }, [setEmployees]);

  useEffect(() => {
    fetch("http://localhost:8086/libraries/normal")
      .then(res => res.json())
      .then(setLibraries)
      .catch(console.error);
  }, [setLibraries]);
  
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        {employees ? (
          employees.map((employee, index) => {
            return <p key={index}>Hello from [{employee.id}] {employee.first_name} {employee.last_name} (hired on: {new Date(employee.hire_date.toLocaleString()).toLocaleDateString('nl-NL')})</p>
          })
        ) : (
          <p>Loading Employees...</p>
        )}
        {libraries ? (
          libraries[0].results.map((library, index) => {
            return <p key={index}>Library: [{library.name}] {library.latest})</p>
          })

        ) : (
          <p>Loading Libraries...</p>
        )}
      </header>
    </div>
  );
}

export default Normal;
