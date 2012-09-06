/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AConcatExpr5 extends PExpr5
{
    private PExpr5 _expr5_;
    private TConcatOp _concatOp_;
    private PExpr6 _expr6_;

    public AConcatExpr5()
    {
        // Constructor
    }

    public AConcatExpr5(
        @SuppressWarnings("hiding") PExpr5 _expr5_,
        @SuppressWarnings("hiding") TConcatOp _concatOp_,
        @SuppressWarnings("hiding") PExpr6 _expr6_)
    {
        // Constructor
        setExpr5(_expr5_);

        setConcatOp(_concatOp_);

        setExpr6(_expr6_);

    }

    @Override
    public Object clone()
    {
        return new AConcatExpr5(
            cloneNode(this._expr5_),
            cloneNode(this._concatOp_),
            cloneNode(this._expr6_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAConcatExpr5(this);
    }

    public PExpr5 getExpr5()
    {
        return this._expr5_;
    }

    public void setExpr5(PExpr5 node)
    {
        if(this._expr5_ != null)
        {
            this._expr5_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expr5_ = node;
    }

    public TConcatOp getConcatOp()
    {
        return this._concatOp_;
    }

    public void setConcatOp(TConcatOp node)
    {
        if(this._concatOp_ != null)
        {
            this._concatOp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._concatOp_ = node;
    }

    public PExpr6 getExpr6()
    {
        return this._expr6_;
    }

    public void setExpr6(PExpr6 node)
    {
        if(this._expr6_ != null)
        {
            this._expr6_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expr6_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expr5_)
            + toString(this._concatOp_)
            + toString(this._expr6_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expr5_ == child)
        {
            this._expr5_ = null;
            return;
        }

        if(this._concatOp_ == child)
        {
            this._concatOp_ = null;
            return;
        }

        if(this._expr6_ == child)
        {
            this._expr6_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expr5_ == oldChild)
        {
            setExpr5((PExpr5) newChild);
            return;
        }

        if(this._concatOp_ == oldChild)
        {
            setConcatOp((TConcatOp) newChild);
            return;
        }

        if(this._expr6_ == oldChild)
        {
            setExpr6((PExpr6) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}