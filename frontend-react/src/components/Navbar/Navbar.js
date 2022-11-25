import * as React from 'react';
import { styled } from '@mui/material';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import { Link } from 'react-router-dom';
import { useHistory } from 'react-router-dom/cjs/react-router-dom.min';

const NavBarLink = styled(Link)({
  textDecoration: 'none',
  boxShadow: 'none',
  color: 'white',
  marginRight: 32
});


const Navbar = () => {

  let history = useHistory();

  const onClick = () => {
    localStorage.removeItem("tokenKey")
    localStorage.removeItem("currentUser")
    localStorage.removeItem("username")
    history.go("/");
  }

  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position='static'>
        <Toolbar>
          <IconButton
            size='large'
            edge='start'
            color='inherit'
            aria-label='menu'
            sx={{ mr: 2 }}
          >
            <MenuIcon />
          </IconButton>
          <Typography
            variant='h6'
            component='div'
            sx={{ flexGrow: 1, textAlign: 'left'}}
          >
            <NavBarLink to='/'>Home</NavBarLink>
          </Typography>
          <Typography
            variant='h6'
            component='div'
          >
            {localStorage.getItem("currentUser") == null ? <NavBarLink to="/auth">Register & Login</NavBarLink> : 
            <div>
              <NavBarLink to={{ pathname: '/users/' + localStorage.getItem("currentUser") }}>Profile</NavBarLink>
              <NavBarLink onClick={onClick}>Logout</NavBarLink>
            </div>}
          </Typography>
        </Toolbar>
      </AppBar>
    </Box>
  );
};

export default Navbar;
