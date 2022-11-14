import * as React from 'react';
import {useState} from "react"
import { styled } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import QuestionAnswerIcon from '@mui/icons-material/QuestionAnswer';
import Box from '@mui/material/Box';
import FavoriteOutlinedIcon from '@mui/icons-material/FavoriteOutlined';



const ExpandMore = styled((props) => {
  const { expand, ...other } = props;
  return <IconButton {...other} />;
})(({ theme, expand }) => ({
  marginLeft: 'auto',
  transition: theme.transitions.create('transform', {
    duration: theme.transitions.duration.shortest,
  }),
}));

const CardActionStyle = styled(CardActions)({
  display: 'flex',
  margin: '0 10px',
  justifyContent: 'space-between'
})

const BoxStyle = styled(Box)({
  display: 'flex',

})

const Blog = (props) => {
  const {title, content} = props;
  const [expanded, setExpanded] = useState(false);

  const handleExpandClick = () => {
    setExpanded(!expanded);
  };


  
  return(
    <Card sx={{ width: 800 }}>
      <CardContent>
        <Typography gutterBottom variant="h5" component="h2" marginBottom="2rem">
          {title}
        </Typography>
        <Typography variant="body1" color="text.primary" component="p" textAlign="left">
          {content}
        </Typography>
      </CardContent>
      <CardActionStyle>
        <BoxStyle>
          <Box ml={2}>
            <Typography gutterBottom variant="subtitle2" component="p">
              Burak Diker
            </Typography>
            <Typography gutterBottom variant="subtitle2" color="textSecondary" component="p">
              15 November 2022
            </Typography>
          </Box>
        </BoxStyle>
        <Box>
          <IconButton>
          <FavoriteOutlinedIcon />
          </IconButton>
          <IconButton>
          <ExpandMore
          expand={expanded}
          onClick={handleExpandClick}
          aria-expanded={expanded}
          aria-label="show more"
        >
          <QuestionAnswerIcon />
        </ExpandMore>
          </IconButton>
        </Box>
      </CardActionStyle>
      <Collapse in={expanded} timeout="auto" unmountOnExit>
        <CardContent>
          <Typography textAlign="left">
          Some content
          </Typography>
        </CardContent>
      </Collapse>
    </Card>
  )

}

export default Blog