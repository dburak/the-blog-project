import './App.css';
import {BrowserRouter, Switch, Route} from "react-router-dom"
import Home from "../src/components/Home/Home"
import User from "../src/components/User/User"
import Navbar from "../src/components/Navbar/Navbar"

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Navbar></Navbar>
        <Switch>
          <Route exact path="/" component={Home}></Route>
          <Route exact path="/users/:userId" component={User}></Route>
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
