select N as Node,
  case when P is null then 'Root'
    when (select count(*) from BST where P = Tree.N ) > 0 then 'Inner'
    else 'Leaf'
  end as NodeType
from BST as Tree
order by Node