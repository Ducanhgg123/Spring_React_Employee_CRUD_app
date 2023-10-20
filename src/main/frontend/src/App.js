import Table from './Table';
import Form from './Form';
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

function App() {
  return (
    <Router>
      <Routes>
        <Route exact path='/' element={<Table />} />
        <Route exact path='/form' element={<Form />} />
        <Route exact path='/form/:id' element={<Form />} />
      </Routes>
    </Router>
  );
}

export default App;
